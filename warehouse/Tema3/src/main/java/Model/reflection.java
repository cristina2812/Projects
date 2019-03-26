package Model;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Field;

public class reflection<T> {
	
    private List<T> createObjects(ResultSet resultSet){
        List<T> list = new ArrayList<T>();

        try {
            try {
                try {
					while(resultSet.next()) {
					    Object type = null;
						T instance =(T) ((Class<?>) type).newInstance();
					    for(java.lang.reflect.Field field:((Class<?>) type).getDeclaredFields()) {
					        Object value = null;
							try {
								value = resultSet.getObject(field.getName());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					        PropertyDescriptor propertyDescriptor = new  PropertyDescriptor(field.getName(), (Class<?>) type);
					        Method method = propertyDescriptor.getWriteMethod();
					        try {
								method.invoke(instance, value);
							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					    }
					    list.add(instance);
					}
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IntrospectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } catch (IllegalAccessException e) {
                ((Throwable) e).printStackTrace();
            }
        }catch(InstantiationException e) {
            e.printStackTrace();
        }

        return list;
    }
}
