
package com.bingo.paging.model;

import java.util.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by ing on 2021/9/16
 * 实体类，对应的是数据库的一张表结构。需要使用注解 @Entity 标记
 *
 * * @PrimaryKey 注解用来标注表的主键，并且使用autoGenerate = true 来指定了主键自增长。
 * * @ColumnInfo 注解用来标注表对应的列的信息比如表名、默认值等等。
 * * @Ignore 注解顾名思义就是忽略这个字段，使用了这个注解的字段将不会在数据库中生成对应的列信息。也可以使用@Entity注解中的 ignoredColumns 参数来指定，效果是一样的。
 */
@Entity(tableName = "movie")
public class Movie {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "no", typeAffinity = ColumnInfo.INTEGER)
    public int no;
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    public int id;
    @ColumnInfo(name = "title", typeAffinity = ColumnInfo.TEXT)
    public String title;
    @ColumnInfo(name = "cover", typeAffinity = ColumnInfo.TEXT)
    public String cover;
    @ColumnInfo(name = "rate", typeAffinity = ColumnInfo.TEXT)
    public String rate;

    @Override
    public String toString() {
        return "Movie{" +
                "no=" + no +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movie movie = (Movie) o;
        return no == movie.no && id == movie.id && Objects.equals(title, movie.title) && Objects.equals(cover, movie.cover) && Objects.equals(rate, movie.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, id, title, cover, rate);
    }
}
