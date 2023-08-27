package com.tatayab.tatayab.base;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BaseActivity2_Factory implements Factory<BaseActivity2> {
  private static final BaseActivity2_Factory INSTANCE = new BaseActivity2_Factory();

  @Override
  public BaseActivity2 get() {
    return provideInstance();
  }

  public static BaseActivity2 provideInstance() {
    return new BaseActivity2();
  }

  public static BaseActivity2_Factory create() {
    return INSTANCE;
  }

  public static BaseActivity2 newBaseActivity2() {
    return new BaseActivity2();
  }
}
