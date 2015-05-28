package com.xuguang.scrollfragment;

import com.xuguang.scrollfragment.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment3 extends Fragment{

	private static Fragment3 af;
	public static Fragment3 getInstance(Bundle args) {
		af = new Fragment3();
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
		view1 = inflater.inflate(R.layout.fragment3, container, false);

		return view1;
	}

}
