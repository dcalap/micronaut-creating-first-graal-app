package example.micronaut;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.RecomputeFieldValue.Kind;
import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import io.netty.handler.codec.compression.JdkZlibEncoder;
import io.netty.handler.codec.compression.ZlibEncoder;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.logging.JdkLoggerFactory;

@TargetClass(io.netty.util.internal.logging.InternalLoggerFactory.class)
final class Target_io_netty_util_internal_logging_InternalLoggerFactory {
    @Substitute
    private static InternalLoggerFactory newDefaultFactory(String name) {
        return JdkLoggerFactory.INSTANCE;
    }
}

@TargetClass(className = "io.micronaut.caffeine.cache.UnsafeRefArrayAccess")
final class Target_io_micronaut_caffeine_cache_UnsafeRefArrayAccess {
    @Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayIndexShift, declClass = Object[].class)
    public static int REF_ELEMENT_SHIFT;
}

@TargetClass(className = "io.netty.util.internal.PlatformDependent0")
final class Target_io_netty_util_internal_PlatformDependent0 {
    @Alias @RecomputeFieldValue(kind = Kind.FieldOffset, //
                    declClassName = "java.nio.Buffer", //
                    name = "address") //
    private static long ADDRESS_FIELD_OFFSET;
}

@TargetClass(className = "io.netty.util.internal.CleanerJava6")
final class Target_io_netty_util_internal_CleanerJava6 {
    @Alias @RecomputeFieldValue(kind = Kind.FieldOffset, //
                    declClassName = "java.nio.DirectByteBuffer", //
                    name = "cleaner") //
    private static long CLEANER_FIELD_OFFSET;
}

@TargetClass(className = "io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess")
final class Target_io_netty_util_internal_shaded_org_jctools_util_UnsafeRefArrayAccess {
    @Alias @RecomputeFieldValue(kind = Kind.ArrayIndexShift, declClass = Object[].class) //
    public static int REF_ELEMENT_SHIFT;
}

@TargetClass(className = "io.netty.handler.codec.compression.ZlibCodecFactory")
final class Target_io_netty_handler_codec_compression_ZlibCodecFactory {

    @Substitute
    public static ZlibEncoder newZlibEncoder(ZlibWrapper wrapper, int compressionLevel, int windowBits, int memLevel) {
        return new JdkZlibEncoder(wrapper, compressionLevel);
    }
}

public class MicronautSubstitutions {
}