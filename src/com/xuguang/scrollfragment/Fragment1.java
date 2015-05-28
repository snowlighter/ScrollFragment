package com.xuguang.scrollfragment;


import com.xuguang.scrollfragment.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment{

	private static Fragment1 af;
	public static Fragment1 getInstance(Bundle args) {
		af = new Fragment1();
		if (args != null) {
			af.setArguments(args);
		}
		return af;
	}

	private FragmentActivity mContext;
	private LayoutInflater layoutInflater;
	private View view1;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		mContext = getActivity();
		layoutInflater = LayoutInflater.from(mContext);
		view1 = inflater.inflate(R.layout.fragment1, container, false);

		return view1;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
	}


}
