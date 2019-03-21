package annotations.databases;

import annotations.DBTable;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
//        System.out.println(args[0]);
//        if (args.length < 1) {
//            System.out.println("arguments: annotated classes");
//            System.exit(0);
//        }
//        for (String className : args
//        ) {
            // 获取指定类对象
        Class<?> cl = Member.class;
        // 获取类对象的注解
        DBTable dbTable = cl.getAnnotation(DBTable.class);
        if (dbTable == null) {
            System.out.println("no dbtable annotations in class "+"Member");
        }
        String tableName = dbTable.name();
//        System.out.println(tableName);
//        }
        String tableCreate = "";
        List<String> columDefs = new ArrayList<>();
        for (Field field : cl.getDeclaredFields()
        ) {
            String columnName = null;
            Annotation[] anns = field.getDeclaredAnnotations();
            if (anns.length < 1) { // 不是tableString
                continue;
            }
            if (anns[0] instanceof SQLInteger) {
                SQLInteger sInt = (SQLInteger) anns[0];
                if (sInt.name().length() < 1) {
                    columnName = field.getName().toUpperCase();
                }
                else
                    columnName = sInt.name();
                columDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
            }
            if (anns[0] instanceof SQLString) {
                SQLString sString = (SQLString) anns[0];
                if (sString.name().length() < 1) {
                    columnName = field.getName().toUpperCase();
                }
                else
                    columnName = sString.name();
                columDefs.add(columnName + " VARCHAR(" + sString.value()+")"+getConstraints(sString.constraints()));
            }
            StringBuilder createdCommand = new StringBuilder(
                    "CREATE TABLE " + tableName + "("
            );
            for (String columDef : columDefs
            ) {
                createdCommand.append("\n   " + columDef + ",");
            }
             tableCreate = createdCommand.substring(
                    0, createdCommand.length() - 1
            ) + ");";

        }
        System.out.println(tableCreate);
    }
    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " NOT NULL";
        }
        if (con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if (con.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }
}
