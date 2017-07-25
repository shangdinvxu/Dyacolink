// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.launch.register;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class SexActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.launch.register.SexActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624130, "field 'manBtn'");
    target.manBtn = finder.castView(view, 2131624130, "field 'manBtn'");
    view = finder.findRequiredView(source, 2131624131, "field 'womanBtn'");
    target.womanBtn = finder.castView(view, 2131624131, "field 'womanBtn'");
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
    target.manBtn = null;
    target.womanBtn = null;
    target.next = null;
  }
}
