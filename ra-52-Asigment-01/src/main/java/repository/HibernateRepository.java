package repository;

public class HibernateRepository {
    private static SessionFactory factory;

    public static Session openSession() {
        if (factory == null || factory.isClosed()) {
            Configuration configuration = new Configuration().configure();
            configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
            factory = configuration.buildSessionFactory();
        }
        return factory.openSession();
    }

    public static void closeFactory() {
        if (factory != null) {
            factory.close();
        }
    }
}
