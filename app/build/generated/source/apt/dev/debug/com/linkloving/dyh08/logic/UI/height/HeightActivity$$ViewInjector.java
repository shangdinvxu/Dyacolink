// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.height;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class HeightActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.height.HeightActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624743, "field 'heightRulerView'");
    target.heightRulerView = finder.castView(view, 2131624743, "field 'heightRulerView'");
    view = finder.findRequiredView(source, 2131624133, "field 'height'");
    target.height = finder.castView(view, 2131624133, "field 'height'");
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
    view = finder.findRequiredView(source, 2131624742, "field 'unitCm'");
    target.unitCm = finder.castView(view, 2131624742, "field 'unitCm'");
    view = finder.findRequiredView(source, 2131624740, "field 'textft'");
    target.textft = finder.castView(view, 2131624740, "field 'textft'");
    view = finder.findRequiredView(source, 2131624741, "field 'textUnitft'");
    target.textUnitft = finder.castView(view, 2131624741, "field 'textUnitft'");
    view = finder.findRequiredView(source, 2131624739, "field 'linerlayout'");
    target.linerlayout = finder.castView(view, 2131624739, "field 'linerlayout'");
  }

  @Override public void reset(T target) {
    target.heightRulerView = null;
    target.height = null;
    target.back = null;
    target.unitCm = null;
    target.textft = null;
    target.textUnitft = null;
    target.linerlayout = null;
  }
}
