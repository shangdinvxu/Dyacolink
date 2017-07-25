// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.setting;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class SettingActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.setting.SettingActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624844, "field 'listview'");
    target.listview = finder.castView(view, 2131624844, "field 'listview'");
  }

  @Override public void reset(T target) {
    target.listview = null;
  }
}
