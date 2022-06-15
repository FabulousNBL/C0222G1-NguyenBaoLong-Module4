package exchange.service;

import org.springframework.stereotype.Service;

@Service
public class ExchangeService implements IExchangeService {
    @Override
    public Double exchange(String number) {
        double num = 0;
        try {
            num = Double.parseDouble(number) * 23000;
        } catch (NumberFormatException e) {
            System.out.println("Enter number");
        }
        return num;
    }
}
