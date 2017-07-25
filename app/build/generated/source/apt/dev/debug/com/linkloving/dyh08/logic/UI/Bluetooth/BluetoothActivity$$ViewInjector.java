// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.Bluetooth;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class BluetoothActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.Bluetooth.BluetoothActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624760, "field 'middleChangeIV'");
    target.middleChangeIV = finder.castView(view, 2131624760, "field 'middleChangeIV'");
    view = finder.findRequiredView(source, 2131624765, "field 'mlistview'");
    target.mlistview = finder.castView(view, 2131624765, "field 'mlistview'");
    view = finder.findRequiredView(source, 2131624766, "field 'btn_Next'");
    target.btn_Next = finder.castView(view, 2131624766, "field 'btn_Next'");
  }

  @Override public void reset(T target) {
    target.middleChangeIV = null;
    target.mlistview = null;
    target.btn_Next = null;
  }
}
