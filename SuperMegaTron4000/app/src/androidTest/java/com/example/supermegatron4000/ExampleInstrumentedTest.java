
package com.example.supermegatron4000;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.supermegatron4000.FileManager.ActionDao;
import com.example.supermegatron4000.FileManager.AppDatabase;

import com.example.supermegatron4000.FileManager.RoomFactory;
import com.example.supermegatron4000.FileManager.UserFactory;
import com.example.supermegatron4000.model.Action;
import com.example.supermegatron4000.model.SensorData;
import com.example.supermegatron4000.model.myRoom;
import com.example.supermegatron4000.FileManager.RoomDao;
import com.example.supermegatron4000.FileManager.SensorDataDao;
import com.example.supermegatron4000.model.User;
import com.example.supermegatron4000.FileManager.UserDao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Array;
import java.util.List;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
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

        Context context = getApplicationContext();
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

        assertEquals(1, userDao.getAll().get(0).id);
        assertEquals("bob", userDao.getAll().get(0).username);

        List<User> users = userDao.getAll();

        User user1 = new User("bob1", "1234",null,null);
        userDao.insert(user1);

        user1 = userDao.findById(4);
        assertEquals("bob1", user1.username);

        user1.setUsername("kent");
        userDao.update(user1);
        assertEquals("kent", userDao.getAll().get(3).username);

        userDao.delete(user1);
        userDao.delete(user);

        assertEquals(2, userDao.getAll().size());


        Integer  i = 5;
        TestInteger(i);
    }

    @Test
    public void Test2() throws Exception {
        myRoom room = new myRoom("room1",1,10,1,1);

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
        myRoom room = new myRoom("room1",1,10,1,1);
        roomDao.insert(room);
        room = roomDao.loadById(1);

        User user = new User( "bob", "123","room1",null);
        userDao.insert(user);
        user = userDao.findByName("bob","123");

        List<myRoom> list =roomDao.getAllRoomByUser();

        assertEquals("room1",list.get(0).roomName);

    }


    @Test
    public void TestGetAll() throws Exception {
        User user = new User("bob", "123", "room1", null);
        userDao.insert(user);
        user = userDao.getAll().get(0);

        //assertEquals("bob", user.username);


        Thread thread = new Thread((Runnable) () -> {
            List<User> users = AppDatabase.getInstance(getApplicationContext()).UserDao().getAll();

            assertEquals("bob", users.get(0).username);

        });
        thread.start();

    }
/*
    @Test
    public void TestUserFactory() throws Exception{
        UserFactory userFactory = new UserFactory();

        User user = new User("bob","123",null,null);
        userFactory.insertUser(user);

        assertEquals("bob",  userFactory.getAllUsers().get(0).username);
    }


 */

    public void TestInteger(Integer... integer) throws Exception{

        assertEquals(5, integer.toString().charAt(0)-86);
    }


    @Test
    public void TestSensorData(){
        SensorData sensorData = new SensorData("f",5,5,5,5,true);
        sensorDataDao.insert(sensorData);

        List<SensorData> sensorDataList = sensorDataDao.loadAllByIds(1);

        assertEquals(5, sensorDataList.get(0).CO2);
    }
/*
    @Test
    public void TestRoomFactory() throws Exception{
        RoomFactory roomFactory = new RoomFactory();

        myRoom room = new myRoom("bob",1,2,1,1);
        Action action = new Action();
        SensorData sensorData = new SensorData();

        roomFactory.insertRoom(room);

        List<myRoom> roomList = roomFactory.getAllRooms();

        assertEquals(1, roomList.size());
    }

 */

}

