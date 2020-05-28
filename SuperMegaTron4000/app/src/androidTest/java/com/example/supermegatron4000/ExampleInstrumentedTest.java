
package com.example.supermegatron4000;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.supermegatron4000.FileManager.ActionDao;
import com.example.supermegatron4000.FileManager.AppDatabase;

import com.example.supermegatron4000.FileManager.myRoom;
import com.example.supermegatron4000.FileManager.RoomDao;
import com.example.supermegatron4000.FileManager.SensorDataDao;
import com.example.supermegatron4000.FileManager.User;
import com.example.supermegatron4000.FileManager.UserDao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static java.sql.Types.NULL;
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

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        userDao = db.UserDao();
        sensorDataDao = db.SensorDataDao();
        roomDao = db.RoomDao();
        actionDao = db.ActionDao();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        User user = new User( "bob", "123",null,null);
        user.setUsername("george");
        userDao.insert(user);
        User byName = userDao.findByName("george", "123");
        assertThat(byName.password, equalTo(user.password));
        assertEquals(byName.username, user.username);

        User user1 = new User("bob1", "1234",null,null);
        userDao.insert(user1);
        user1 = userDao.findByName("bob1","1234");

        int intarray[] = new int[]{1, 2};
        assertEquals(userDao.loadAllByIds(intarray).get(1).id, 2);

        user1.setUsername("kent");
        userDao.update(user1);
        assertEquals(userDao.loadAllByIds(intarray).get(1).username, "kent");

        userDao.delete(user1);
        userDao.delete(byName);
        assertEquals(0, userDao.getAll().size());
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

