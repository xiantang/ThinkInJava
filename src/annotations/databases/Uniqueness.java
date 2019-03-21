package annotations.databases;

public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);

}
