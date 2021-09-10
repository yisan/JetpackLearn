package com.bingo.databinding6;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;

/**
 * Created by ing on 2021/9/10
 */
public class ImageViewBindingAdapter {
    // 网络图片
//    @BindingAdapter("image")
//    public static void setImage(ImageView imageView, String url) {
//        if (!TextUtils.isEmpty(url)) {
//            Glide.with(imageView.getContext()).load(url).placeholder(R.drawable.ic_launcher_background).into(imageView);
//        } else {
//            imageView.setBackgroundColor(Color.GRAY);
//        }
//    }

    //本地图片
//    @BindingAdapter("image")
//    public static void setImage(ImageView imageView, int resId) {
//        imageView.setImageResource(resId);
//    }

    //参数可选 加载图片 当网络图片为空时，加载本地图片
    @BindingAdapter(value = {"image", "defaultImageResource"}, requireAll = false)
    public static void setImage(ImageView imageView, String url, int resId) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(imageView.getContext()).load(url).placeholder(R.drawable.ic_launcher_background).into(imageView);
        } else {
            imageView.setImageResource(resId);
        }
    }
}
