// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.settings;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PersonalInfoActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.settings.PersonalInfoActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624244, "field 'userHead' and method 'setUserHead'");
    target.userHead = finder.castView(view, 2131624244, "field 'userHead'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setUserHead(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624833, "field 'editNickname'");
    target.editNickname = finder.castView(view, 2131624833, "field 'editNickname'");
    view = finder.findRequiredView(source, 2131624834, "field 'radioMan'");
    target.radioMan = finder.castView(view, 2131624834, "field 'radioMan'");
    view = finder.findRequiredView(source, 2131624835, "field 'radioWoman'");
    target.radioWoman = finder.castView(view, 2131624835, "field 'radioWoman'");
    view = finder.findRequiredView(source, 2131624836, "field 'editYear'");
    target.editYear = finder.castView(view, 2131624836, "field 'editYear'");
    view = finder.findRequiredView(source, 2131624837, "field 'editMon'");
    target.editMon = finder.castView(view, 2131624837, "field 'editMon'");
    view = finder.findRequiredView(source, 2131624838, "field 'editDay'");
    target.editDay = finder.castView(view, 2131624838, "field 'editDay'");
    view = finder.findRequiredView(source, 2131624839, "field 'radioLeft' and method 'setRadioLeft'");
    target.radioLeft = finder.castView(view, 2131624839, "field 'radioLeft'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setRadioLeft(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624840, "field 'radioRight' and method 'setRadioRight'");
    target.radioRight = finder.castView(view, 2131624840, "field 'radioRight'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setRadioRight(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624841, "field 'radioRemOn' and method 'setRadioRemOn'");
    target.radioRemOn = finder.castView(view, 2131624841, "field 'radioRemOn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setRadioRemOn(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624842, "field 'radioRemOff' and method 'setRadioRemOff'");
    target.radioRemOff = finder.castView(view, 2131624842, "field 'radioRemOff'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setRadioRemOff(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624843, "field 'btnEnter' and method 'enter'");
    target.btnEnter = finder.castView(view, 2131624843, "field 'btnEnter'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.enter(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624588, "field 'birthday' and method 'setBirthday'");
    target.birthday = finder.castView(view, 2131624588, "field 'birthday'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setBirthday(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624325, "field 'layoutPeosoninfo'");
    target.layoutPeosoninfo = finder.castView(view, 2131624325, "field 'layoutPeosoninfo'");
  }

  @Override public void reset(T target) {
    target.userHead = null;
    target.editNickname = null;
    target.radioMan = null;
    target.radioWoman = null;
    target.editYear = null;
    target.editMon = null;
    target.editDay = null;
    target.radioLeft = null;
    target.radioRight = null;
    target.radioRemOn = null;
    target.radioRemOff = null;
    target.btnEnter = null;
    target.birthday = null;
    target.layoutPeosoninfo = null;
  }
}
