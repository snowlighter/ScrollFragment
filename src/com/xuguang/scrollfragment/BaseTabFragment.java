package com.xuguang.scrollfragment;

import java.util.ArrayList;
import java.util.List;

import com.xuguang.scrollfragment.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class BaseTabFragment extends Fragment implements
		OnClickListener{
	public ViewPager viewPage;
	private TextView tabTv1, tabTv2, tabTv3;
	private final int FRAGMENT_COUNT = 3;// 默认的fragment数量
	private View rootView;
	private RelativeLayout line;
	private View titleLayoutView;
	public LinearLayout titleLayout;
	// 下划线宽
	private int lineWidth;
	// 下划线当前位置
	private int linePosition;
	/**
	 * 当前点击第几个页面
	 */
	public int currentIndex = 0;
	/*
	 * 存放3个Fragment
	 */
	private List<Fragment> fragmentsList;


	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	public TextView getTabTv1() {
		return tabTv1;
	}

	public void setTabTv1(TextView tabTv1) {
		this.tabTv1 = tabTv1;
	}

	public TextView getTabTv2() {
		return tabTv2;
	}

	public void setTabTv2(TextView tabTv2) {
		this.tabTv2 = tabTv2;
	}

	public TextView getTabTv3() {
		return tabTv3;
	}

	public void setTabTv3(TextView tabTv3) {
		this.tabTv3 = tabTv3;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.indextab_main, container, false);

		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		initTitleView(getView());
		initViewPager(getView(), FRAGMENT_COUNT);
		super.onActivityCreated(savedInstanceState);

	}

	public abstract List<Fragment> addFragment();

	/**
	 * 初始化下划线
	 */
	@SuppressLint("NewApi")
	public void initLineView(View view) {
		Display display = getActivity().getWindowManager().getDefaultDisplay();
		lineWidth = display.getWidth() / 3;
		line = (RelativeLayout) view.findViewById(R.id.line);// 底部横线
		android.view.ViewGroup.LayoutParams lp = line.getLayoutParams();
		lp.width = lineWidth;
		line.setLayoutParams(lp);
		linePosition = (int) line.getX();
	}

	public void initTitleView(View view) {
		
		titleLayoutView = view.findViewById(R.id.poiTop);
		titleLayout = (LinearLayout) titleLayoutView
				.findViewById(R.id.titleTopLayout);
		tabTv1 = (TextView) titleLayoutView.findViewById(R.id.fragment1);
		tabTv1.setTextColor(getResources().getColor(R.color.text_color10c257));
		initLineView(titleLayoutView);
		tabTv2 = (TextView) titleLayoutView.findViewById(R.id.fragment2);
		tabTv3 = (TextView) titleLayoutView.findViewById(R.id.fragment3);
		tabTv1.setOnClickListener(this);
		tabTv2.setOnClickListener(this);
		tabTv3.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.fragment1:
			currentIndex = 0;
			viewPage.setCurrentItem(0);
			break;
		case R.id.fragment2:
			currentIndex = 1;
			viewPage.setCurrentItem(1);
			break;
		case R.id.fragment3:
			currentIndex = 2;
			viewPage.setCurrentItem(2);
			break;
		}
		changTextColor(titleLayout, currentIndex);
	}
	public void changTextColor(LinearLayout parent, int curent) {
		for (int i = 0; i < parent.getChildCount(); i++) {
			RelativeLayout child = (RelativeLayout) parent.getChildAt(i);
			if (i == curent) {
				((TextView)child.getChildAt(0)).setTextColor(getResources().getColor(R.color.text_color10c257));
			} else {
				((TextView)child.getChildAt(0)).setTextColor(getResources().getColor(
						R.color.text_color313131));
			}

		}
	}

	private IndexPagerAdapter pAdapter;

	/**
	 * 初始化ViewPager
	 */
	public void initViewPager(View view, int fragmentCount) {
		fragmentsList = addFragment();
		if (fragmentsList == null) {
			fragmentsList = new ArrayList<Fragment>();
			for (int i = 0; i < fragmentCount; i++) {
				fragmentsList.add(new Fragment());
			}
		}

		viewPage = (ViewPager) view.findViewById(R.id.homeVp);
		pAdapter = new IndexPagerAdapter(getFragmentManager(), fragmentsList);
		viewPage.setAdapter(pAdapter);
		viewPage.setCurrentItem(0);
		viewPage.setOnPageChangeListener(new MyOnPageChangeListener());

	}

	public class MyOnPageChangeListener implements OnPageChangeListener {

		private boolean isScrolling;

		@Override
		public void onPageSelected(int arg0) {
			currentIndex = arg0;
			changTextColor(titleLayout, currentIndex);
		}
//arg0 :当前页面，及你点击滑动的页面 arg1:当前页面偏移的百分比 arg2:当前页面偏移的像素位置   
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			Animation animation = null;
			int toX = 0;
			toX = (int) ((arg0+arg1)* lineWidth);
			animation = new TranslateAnimation(linePosition, toX, 0, 0);
			linePosition = toX;
			animation.setFillAfter(true);
			line.startAnimation(animation);
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}
	@Override
	public void onResume() {
		super.onResume();
	}
	
	@Override
	public void onPause() {
		super.onPause();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	

}
