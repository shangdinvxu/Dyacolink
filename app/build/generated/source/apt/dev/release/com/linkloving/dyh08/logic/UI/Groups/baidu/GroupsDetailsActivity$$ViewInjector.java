// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.Groups.baidu;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class GroupsDetailsActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.Groups.baidu.GroupsDetailsActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624788, "field 'gourpsTopmap'");
    target.gourpsTopmap = finder.castView(view, 2131624788, "field 'gourpsTopmap'");
    view = finder.findRequiredView(source, 2131624789, "field 'groupsTime'");
    target.groupsTime = finder.castView(view, 2131624789, "field 'groupsTime'");
    view = finder.findRequiredView(source, 2131624790, "field 'groupsTvStep'");
    target.groupsTvStep = finder.castView(view, 2131624790, "field 'groupsTvStep'");
    view = finder.findRequiredView(source, 2131624791, "field 'groupsTvCalories'");
    target.groupsTvCalories = finder.castView(view, 2131624791, "field 'groupsTvCalories'");
    view = finder.findRequiredView(source, 2131624792, "field 'groupsTvDistance'");
    target.groupsTvDistance = finder.castView(view, 2131624792, "field 'groupsTvDistance'");
    view = finder.findRequiredView(source, 2131624793, "field 'groupsTvDuration'");
    target.groupsTvDuration = finder.castView(view, 2131624793, "field 'groupsTvDuration'");
    view = finder.findRequiredView(source, 2131624794, "field 'shareIcon'");
    target.shareIcon = finder.castView(view, 2131624794, "field 'shareIcon'");
  }

  @Override public void reset(T target) {
    target.gourpsTopmap = null;
    target.groupsTime = null;
    target.groupsTvStep = null;
    target.groupsTvCalories = null;
    target.groupsTvDistance = null;
    target.groupsTvDuration = null;
    target.shareIcon = null;
  }
}
