package jdbc;
import collection.Item;

import java.util.List;

public interface DAO {
    //����
    public void add(Item item);
    //�޸�
    public void update(Item item);
    //ɾ��
    public void delete(int id);
    //��ȡ
    public Item get(int id);
    //��ѯ
    public List<Item> list();
    //��ҳ��ѯ
    public List<Item> list(int start,int count);

}
