package ClassListFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.no_1n.R;

import java.util.ArrayList;

import ClassList_VideoFragment.ClassList_VideoFragment1;
import ClassList_VideoFragment.ClassList_VideoFragment2;

public class ClassListFragment1 extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_class_list1, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager videoView = (ViewPager) getView().findViewById(R.id.video_view);

        VideoPagerAdapterForFragment1 adapter = new VideoPagerAdapterForFragment1(getChildFragmentManager());
        ClassList_VideoFragment2 classListVideoFragment1 = new ClassList_VideoFragment2();
        adapter.addVideo(classListVideoFragment1);
        ClassList_VideoFragment2 classListVideoFragment2 = new ClassList_VideoFragment2();
        adapter.addVideo(classListVideoFragment2);

        videoView.setAdapter(adapter);
    }

    class VideoPagerAdapterForFragment1 extends FragmentStatePagerAdapter {
        ArrayList<Fragment> videos = new ArrayList<Fragment>();

        public VideoPagerAdapterForFragment1(@NonNull FragmentManager fm) {
            super(fm);
        }

        public void addVideo(Fragment video){
            videos.add(video);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return videos.get(position);
        }

        @Override
        public int getCount() {
            return videos.size();
        }
    }
}