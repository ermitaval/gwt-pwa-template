package com.vaadin.polymer.demo.client;

import com.vaadin.polymer.elemental.EventListener;
import com.vaadin.polymer.elemental.HTMLElement;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;

public abstract class NetworkStatus {

  @JsProperty(namespace = "navigator")
  public static native boolean isOnLine();
  
  @JsProperty(namespace = JsPackage.GLOBAL)
  public static native HTMLElement getWindow();

  public static void onOffline(EventListener<?> f) {
    getWindow().addEventListener("offline", f);
  }

  public static void onOnline(EventListener<?> f) {
    getWindow().addEventListener("online", f);
  }

  public static void onChange(EventListener<?> f) {
    onOnline(f);
    onOffline(f);
  }
}
