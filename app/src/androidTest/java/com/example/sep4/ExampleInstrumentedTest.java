package com.example.sep4;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.sep4.FileManager.AppDatabase;
import com.example.sep4.FileManager.BaseDao;
import com.example.sep4.FileManager.User;
import com.example.sep4.FileManager.UserDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.ArrayList;
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
    private UserDao userDao;
    private AppDatabase db;


    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        userDao = db.UserDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {

        com.example.sep4.FileManager.User user = new com.example.sep4.FileManager.User(1,"bob","123");
        user.setUsername("george");
        userDao.insert(user);
        User byName = userDao.findByName("george","123");
        assertThat(byName.password, equalTo(user.password));
        assertEquals(byName.username, user.username);

        com.example.sep4.FileManager.User user1 = new com.example.sep4.FileManager.User(2,"bob1","1234");
        userDao.insert(user1);

        int intarray[]= new int[]{1,2};
        assertEquals(userDao.loadAllByIds(intarray).get(1).id, 2);

        user1.setUsername("kent");
        userDao.update(user1);
        assertEquals(userDao.loadAllByIds(intarray).get(1).username, "kent");

        userDao.delete(user1);
        userDao.delete(user);
        assertEquals(0,userDao.getAll().size());


    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.sep4", appContext.getPackageName());
    }


}
