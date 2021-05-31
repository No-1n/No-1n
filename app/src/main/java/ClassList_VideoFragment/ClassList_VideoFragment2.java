package ClassList_VideoFragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.no_1n.R;

public class ClassList_VideoFragment2 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_class_list__video2, container, false);
        MediaController mc = new MediaController(getActivity());
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.receive;

        VideoView video = (VideoView) rootView.findViewById(R.id.classVideo);
        video.setVideoURI(Uri.parse(videoPath));
        video.setMediaController(mc);
        //video.start();
        return rootView;
    }
}