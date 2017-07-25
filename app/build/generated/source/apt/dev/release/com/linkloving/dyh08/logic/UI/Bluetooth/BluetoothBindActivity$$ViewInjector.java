// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.Bluetooth;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class BluetoothBindActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.Bluetooth.BluetoothBindActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624760, "field 'blueMiddleChangeIV'");
    target.blueMiddleChangeIV = finder.castView(view, 2131624760, "field 'blueMiddleChangeIV'");
    view = finder.findRequiredView(source, 2131624426, "field 'equipmentName'");
    target.equipmentName = finder.castView(view, 2131624426, "field 'equipmentName'");
    view = finder.findRequiredView(source, 2131624427, "field 'equipmentAdress'");
    target.equipmentAdress = finder.castView(view, 2131624427, "field 'equipmentAdress'");
    view = finder.findRequiredView(source, 2131624428, "field 'listItemImageview'");
    target.listItemImageview = finder.castView(view, 2131624428, "field 'listItemImageview'");
    view = finder.findRequiredView(source, 2131624761, "field 'cancel' and method 'clickReconnect'");
    target.cancel = finder.castView(view, 2131624761, "field 'cancel'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.clickReconnect(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624762, "field 'confirm' and method 'clickDisconnect'");
    target.confirm = finder.castView(view, 2131624762, "field 'confirm'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.clickDisconnect(p0);
        }
      });
  }

  @Override public void reset(T target) {
    target.blueMiddleChangeIV = null;
    target.equipmentName = null;
    target.equipmentAdress = null;
    target.listItemImageview = null;
    target.cancel = null;
    target.confirm = null;
  }
}
