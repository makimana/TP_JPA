package service;

public interface GenericDAO<T, PK >{
    T create(T t);
    T read(PK id);
    T update(T t);
    void delete(T t);
}

