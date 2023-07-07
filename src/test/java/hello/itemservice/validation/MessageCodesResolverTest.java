package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
//        for (String messageCode : messageCodes) {
//            System.out.println("messageCodes = " + messageCode);
//        }
        //assertj
        assertThat(messageCodes).containsExactly("required.item","required");

    }

    @Test
    void messageCodesResolverField() {
        // rejectValue(), reject() 는 내부에서 MessageCodesResolver 를 사용한다. 여기에서 메시지 코드 생성
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        for (String messageCode : messageCodes ) {
            System.out.println("messageCodes = " + messageCode);
        }
        assertThat(messageCodes).containsExactly("required.item.itemName",
                    "required.itemName","required.java.lang.String", "required");
    }


}
