package com.bingo.room2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Created by ing on 2021/9/13
 * <p>
 * 如果用户设备上的数据库版本为1，而当前需要安装的app数据库版本为3
 * -- Room会先判断当前有没有直接从1到3的升级方案，如果有，就直接执行1到3的方案。
 * 如果没有，那么Room会安装顺序先后执行Migration(1,2) 、Migration(2,3)完成升级。
 */
@Database(entities = {Student.class}, version = 4, exportSchema = true)
public abstract class MyDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "my_db.db";
    private static MyDatabase mInstance;

    //这里不能写私有的构造函数,会报错。room会自动生成实现类。
//    private MyDatabase(){}
    public static synchronized MyDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(),
                    MyDatabase.class,
                    DATABASE_NAME)
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3,MIGRATION_3_4)
                    // 如果数据库升级发生异常，比如升级到没有的版本。
                    // 添加fallbackToDestructiveMigration的话不会报异常，程序正常运行，但是数据表会重建，数据丢失。
//                    .fallbackToDestructiveMigration()
                    .build();
        }
        return mInstance;
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE student ADD COLUMN sex INTEGER NOT NULL DEFAULT 1");
        }
    };
    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE student ADD COLUMN score INTEGER NOT NULL DEFAULT 1");
        }
    };
    // 数据库的销毁重建
    static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //1.创建临时表
            database.execSQL("CREATE TABLE temp_student ( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "name TEXT," +
                    "age INTEGER NOT NULL," +
                    "sex TEXT DEFAULT 'M'," +
                    "score INTEGER NOT NULL DEFAULT 1)");
            //2.复制数据到临时表
            database.execSQL("INSERT INTO temp_student (name,age,sex,score) " +
                    "SELECT name,age,sex,score FROM student");
            //3.删除原表
            database.execSQL("DROP TABLE student");
            //4.重命名临时表
            database.execSQL("ALTER TABLE temp_student RENAME TO student");
        }
    };

    // room会帮我们自动实现
    public abstract StudentDao getStudentDao();
}
