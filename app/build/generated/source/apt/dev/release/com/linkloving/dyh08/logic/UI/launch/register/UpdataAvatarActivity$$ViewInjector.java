// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.launch.register;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class UpdataAvatarActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.launch.register.UpdataAvatarActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624244, "field 'user_head' and method 'changeHead'");
    target.user_head = finder.castView(view, 2131624244, "field 'user_head'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.changeHead();
        }
      });
    view = finder.findRequiredView(source, 2131624401, "field 'nickName'");
    target.nickName = finder.castView(view, 2131624401, "field 'nickName'");
    view = finder.findRequiredView(source, 2131624142, "field 'next' and method 'next'");
    target.next = finder.castView(view, 2131624142, "field 'next'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.next();
        }
      });
  }

  @Override public void reset(T target) {
    target.user_head = null;
    target.nickName = null;
    target.next = null;
  }
}
