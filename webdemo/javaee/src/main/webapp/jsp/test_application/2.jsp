/*  */ public @interface WebFilter {
/*  */   String description() default "";
/*  */   String displayName() default "";
/*  */   WebInitParam[] initParams() default {};
/*  */   String filterName() default "";
/*  */   String smallIcon() default "";
/*  */   String largeIcon() default "";
/*  */   String[] value() default {};
/*  */   String[] urlPatterns() default {};
/*  */   boolean asyncSupported() default false;
/*  */   
/*  */   String[] servletNames() default {};
/*  */   DispatcherType[] dispatcherTypes() default {DispatcherType.REQUEST};
