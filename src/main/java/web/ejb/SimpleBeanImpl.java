package web.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;
@Stateless
@Remote(SimpleBeanIF.class)
public class SimpleBeanImpl implements SimpleBeanIF {
    @Override
    public int incrementNumber(int n) {
        return n+1;
    }
}