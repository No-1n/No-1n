package MyCenterFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.no_1n.R;

import java.util.ArrayList;

import MyCentetBannerFragment.MyCenter_BannerFragment3;
import MyCentetBannerFragment.MyCenter_BannerFragment4;

public class MyCenterFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_my_center1, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager bannerView = (ViewPager) getView().findViewById(R.id.banner_view);

        BannerPagerAdapterForFragment2 adapter = new BannerPagerAdapterForFragment2(getChildFragmentManager());
        MyCenter_BannerFragment3 bannerFragment3 = new MyCenter_BannerFragment3();
        adapter.addBanner(bannerFragment3);
        MyCenter_BannerFragment4 bannerFragment4 = new MyCenter_BannerFragment4();
        adapter.addBanner(bannerFragment4);

        bannerView.setAdapter(adapter);

    }

    class BannerPagerAdapterForFragment2 extends FragmentStatePagerAdapter {
        ArrayList<Fragment> banners = new ArrayList<Fragment>();

        public BannerPagerAdapterForFragment2(@NonNull FragmentManager fm) {
            super(fm);
        }

        public void addBanner(Fragment banner){
            banners.add(banner);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return banners.get(position);
        }

        @Override
        public int getCount() {
            return banners.size();
        }
    }
}