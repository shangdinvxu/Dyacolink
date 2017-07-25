// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.Bluetooth;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class BluetoothDisconnectActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.Bluetooth.BluetoothDisconnectActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624760, "field 'blueMiddleChangeIV'");
    target.blueMiddleChangeIV = finder.castView(view, 2131624760, "field 'blueMiddleChangeIV'");
    view = finder.findRequiredView(source, 2131624763, "field 'cancel' and method 'onCancel'");
    target.cancel = finder.castView(view, 2131624763, "field 'cancel'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onCancel(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624764, "field 'confirm' and method 'onConfirm'");
    target.confirm = finder.castView(view, 2131624764, "field 'confirm'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onConfirm(p0);
        }
      });
  }

  @Override public void reset(T target) {
    target.blueMiddleChangeIV = null;
    target.cancel = null;
    target.confirm = null;
  }
}
