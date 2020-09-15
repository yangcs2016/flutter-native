package yangcs2020.com.flutter_app_native;


import io.flutter.plugin.common.PluginRegistry;

public class MyViewFlutterPlugin {
    public static void registerWith(PluginRegistry registry){
        final String key =MyViewFlutterPlugin.class.getCanonicalName();

        if (registry.hasPlugin(key)) return;
        PluginRegistry.Registrar newRegistrar = registry.registrarFor(key);
        newRegistrar.platformViewRegistry().registerViewFactory("plugin.yangcs/demo",new MyViewFactory(newRegistrar.messenger()));
    }
}
