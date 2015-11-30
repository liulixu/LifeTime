package org.jiangtao.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import org.jiangtao.lifetime.R;

/**
 * A simple {@link Fragment} subclass.
 * 所有的动态信息
 */
public class DynamicInfoFragment extends android.support.v4.app.Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private View mView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ImageView mImageView;
    private ListView mListView;

    public DynamicInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_dynamic_info, container, false);
        controlsInit();
        showImageView();
        return mView;
    }

    private void controlsInit() {
        mSwipeRefreshLayout = (SwipeRefreshLayout)
                mView.findViewById(R.id.container_dynamicinfofragment);
        mImageView = (ImageView) mView.findViewById(R.id.imageview_fragment_friend_info);
        mListView = (ListView) mView.findViewById(R.id.listview_fragment_friend_info);
    }


    @Override
    public void onRefresh() {
        sRfOnReFreshListener();
    }

    public void sRfOnReFreshListener() {
        mSwipeRefreshLayout.setEnabled(true);
        mSwipeRefreshLayout.setColorScheme(android.R.color.holo_red_light,
                android.R.color.holo_green_light,
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light);
    }

    /**
     * 有网或者有缓存
     */
    private void hideImageView() {

        mImageView.setVisibility(View.GONE);
    }

    /**
     * 没网，没缓存
     */
    private void showImageView() {
        mImageView.setVisibility(View.VISIBLE);
    }
}