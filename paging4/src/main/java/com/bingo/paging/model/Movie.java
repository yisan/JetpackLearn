
package com.bingo.paging.model;

import java.util.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by ing on 2021/9/16
 */
@Entity(tableName = "movie")
public class Movie {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "no", typeAffinity = ColumnInfo.INTEGER)
    private int no;
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    private int id;
    @ColumnInfo(name = "title", typeAffinity = ColumnInfo.TEXT)
    private String title;
    @ColumnInfo(name = "cover", typeAffinity = ColumnInfo.TEXT)
    private String cover;
    @ColumnInfo(name = "rate", typeAffinity = ColumnInfo.TEXT)
    private String rate;

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
        return no == movie.no &&
                id == movie.id &&
                Objects.equals(title, movie.title) &&
                Objects.equals(cover, movie.cover) &&
                Objects.equals(rate, movie.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, id, title, cover, rate);
    }
}
