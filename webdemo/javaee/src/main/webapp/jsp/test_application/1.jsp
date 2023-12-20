/*  */ public @interface WebServlet {
/*  */   String description() default "";
/*  */   String displayName() default "";
/*  */   WebInitParam[] initParams() default {};
/*  */   String name() default "";
/*  */   String smallIcon() default "";
/*  */   String largeIcon() default "";
/*  */   String[] value() default {};
/*  */   String[] urlPatterns() default {};
/*  */   boolean asyncSupported() default false;
/*  */   
/*  */   int loadOnStartup() default -1;
