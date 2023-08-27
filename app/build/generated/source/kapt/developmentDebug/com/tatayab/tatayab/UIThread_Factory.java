package com.tatayab.tatayab;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UIThread_Factory implements Factory<UIThread> {
  private static final UIThread_Factory INSTANCE = new UIThread_Factory();

  @Override
  public UIThread get() {
    return provideInstance();
  }

  public static UIThread provideInstance() {
    return new UIThread();
  }

  public static UIThread_Factory create() {
    return INSTANCE;
  }

  public static UIThread newUIThread() {
    return new UIThread();
  }
}
