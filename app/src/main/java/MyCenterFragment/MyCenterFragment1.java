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

import MyCentetBannerFragment.MyCenter_BannerFragment1;
import MyCentetBannerFragment.MyCenter_BannerFragment2;
import com.example.no_1n.R;

import java.util.ArrayList;

public class MyCenterFragment1 extends Fragment {

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

        BannerPagerAdapterForFragment1 adapter = new BannerPagerAdapterForFragment1(getChildFragmentManager());
        MyCenter_BannerFragment1 bannerFragment1 = new MyCenter_BannerFragment1();
        adapter.addBanner(bannerFragment1);
        MyCenter_BannerFragment2 bannerFragment2 = new MyCenter_BannerFragment2();
        adapter.addBanner(bannerFragment2);

        bannerView.setAdapter(adapter);

    }

    class BannerPagerAdapterForFragment1 extends FragmentStatePagerAdapter{
        ArrayList<Fragment> banners = new ArrayList<Fragment>();

        public BannerPagerAdapterForFragment1(@NonNull FragmentManager fm) {
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