package com.zedlab.embersolutionofficial.Controllers.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.zedlab.embersolutionofficial.R;

public class SliderAdapter extends PagerAdapter {

    private Context context;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    private int[] images = {
            R.drawable.delivery,
            R.drawable.ember_clipart,
            R.drawable.bank,
            R.drawable.progression
    };

    private int[] headings = {
            R.string.first_slide_heading,
            R.string.second_slide_heading,
            R.string.third_slide_heading,
            R.string.fourth_slide_heading
    };

    private int[] descriptions = {
            R.string.first_slide_desc,
            R.string.second_slide_desc,
            R.string.third_slide_desc,
            R.string.fourth_slide_desc
    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout, container, false);

        // Hooks
        AppCompatImageView imageView = view.findViewById(R.id.slider_image);
        TextView heading = view.findViewById(R.id.slider_heading);
        TextView description = view.findViewById(R.id.slider_description);

        imageView.setImageResource(images[position]);
        heading.setText(headings[position]);
        description.setText(descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
