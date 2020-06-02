
package com.example.supermegatron4000;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.supermegatron4000.FileManager.ActionDao;
import com.example.supermegatron4000.FileManager.AppDatabase;

import com.example.supermegatron4000.FileManager.DBHelper;
import com.example.supermegatron4000.FileManager.SensorData;
import com.example.supermegatron4000.FileManager.myRoom;
import com.example.supermegatron4000.FileManager.RoomDao;
import com.example.supermegatron4000.FileManager.SensorDataDao;
import com.example.supermegatron4000.FileManager.User;
import com.example.supermegatron4000.FileManager.UserDao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.logappdev2", appContext.getPackageName());
    }

    private AppDatabase db;
    private UserDao userDao;
    private SensorDataDao sensorDataDao;
    private RoomDao roomDao;
    private ActionDao actionDao;

/*
    DBHelper dbHelper;
    ActionDao actionDao;
    RoomDao roomDao;
    SensorDataDao sensorDataDao;
    UserDao userDao;

 */

    @Before
    public void createDb() throws InterruptedException {

        Context context = ApplicationProvider.getApplicationContext();
        //db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        db = AppDatabase.getInstance(context);
        userDao = db.UserDao();
        sensorDataDao = db.SensorDataDao();
        roomDao = db.RoomDao();
        actionDao = db.ActionDao();
        /*
        dbHelper = new DBHelper();
        dbHelper.createDb();
        actionDao = dbHelper.getActionDao();
        roomDao = dbHelper.getRoomDao();
        sensorDataDao = dbHelper.getSensorDataDao();
        userDao = dbHelper.getUserDao();

         */
    }

    @Test
    public void writeUserAndReadInList() throws Exception {

        User user = new User("bob", "123",null,null);
        userDao.insert(user);
        user = userDao.findById(1);
        //userDao.update(user);
        assertEquals(1, userDao.getAll().get(0).id);
        assertEquals("bob", userDao.getAll().get(0).username);

        List<User> users = userDao.getAll();

        User user1 = new User("bob1", "1234",null,null);
        userDao.insert(user1);

        user1 = userDao.findById(3);
        assertEquals("bob1", user1.username);

        user1.setUsername("kent");
        userDao.update(user1);
        assertEquals("kent", userDao.getAll().get(2).username);

        userDao.delete(user1);
        userDao.delete(user);

        //Ved ikke hvorfor jeg får en extra her
        assertEquals(1, userDao.getAll().size());
    }

    @Test
    public void Test2() throws Exception {
        myRoom room = new myRoom("room1",1,10,"Go","Data");

        roomDao.insert(room);
        myRoom room1 = roomDao.loadById(1);
        assertEquals(room1.getId(),1);

        myRoom room2 = new myRoom();
        roomDao.insert(room2);
        room2 = roomDao.loadById(2);
        assertEquals(room2.id,2);

        room2 = room1;
        roomDao.update(room2);
        assertEquals(room2.id, 1);

        roomDao.delete(room2);
        room2 = roomDao.loadById(1);

        assertEquals(room2, null);

    }

    @Test
    public void TestGetAllRoomByUser() throws Exception {
        myRoom room = new myRoom("room1",1,10,"Go","Data");
        roomDao.insert(room);
        room = roomDao.loadById(1);

        User user = new User( "bob", "123","room1",null);
        userDao.insert(user);
        user = userDao.findByName("bob","123");

        List<myRoom> list =roomDao.getAllRoomByUser();

        assertEquals("room1",list.get(0).roomName);

    }
}

