// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.weight;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class WeightActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.weight.WeightActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624757, "field 'weightRulerView'");
    target.weightRulerView = finder.castView(view, 2131624757, "field 'weightRulerView'");
    view = finder.findRequiredView(source, 2131624136, "field 'weight'");
    target.weight = finder.castView(view, 2131624136, "field 'weight'");
    view = finder.findRequiredView(source, 2131624744, "field 'back' and method 'back'");
    target.back = finder.castView(view, 2131624744, "field 'back'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.back(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624756, "field 'unitkg'");
    target.unitkg = finder.castView(view, 2131624756, "field 'unitkg'");
  }

  @Override public void reset(T target) {
    target.weightRulerView = null;
    target.weight = null;
    target.back = null;
    target.unitkg = null;
  }
}
