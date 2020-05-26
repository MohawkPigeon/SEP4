
package com.example.supermegatron4000;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.supermegatron4000.FileManager.ActionDao;
import com.example.supermegatron4000.FileManager.AppDatabase;
import com.example.supermegatron4000.FileManager.BaseDao;
import com.example.supermegatron4000.FileManager.RoomDao;
import com.example.supermegatron4000.FileManager.SensorDataDao;
import com.example.supermegatron4000.FileManager.User;
import com.example.supermegatron4000.FileManager.UserDao;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

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
        User user = new User(1, "bob", "123",null,null);
        user.setUsername("george");
        userDao.insert(user);
        User byName = userDao.findByName("george", "123");
        assertThat(byName.password, equalTo(user.password));
        assertEquals(byName.username, user.username);

        User user1 = new com.example.supermegatron4000.FileManager.User(2, "bob1", "1234",null,null);
        userDao.insert(user1);

        int intarray[] = new int[]{1, 2};
        assertEquals(userDao.loadAllByIds(intarray).get(1).id, 2);

        user1.setUsername("kent");
        userDao.update(user1);
        assertEquals(userDao.loadAllByIds(intarray).get(1).username, "kent");

        userDao.delete(user1);
        userDao.delete(user);
        assertEquals(0, userDao.getAll().size());
    }
}

