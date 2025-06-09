import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class assertJTest {

    @Mock
    GPT mockGpt;

    @Test
    void name2() {
        when(mockGpt.use(anyString())).thenReturn("모킹");

        Cal cal = new Cal(mockGpt);
        String ret = cal.getContext("나");

        System.out.println(ret);

        assertThat(ret).isEqualTo("모킹");
        verify(mockGpt, times(1)).use(anyString());
    }

}
