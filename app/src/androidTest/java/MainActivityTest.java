import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import com.agilefaqs.chatapp.MainActivity;
import com.confengine.chatapp.R;

import org.junit.Test;

/**
 * Created by yashpreet on 04/07/16.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;
    private EditText messageInput;
    private Button sendMessageButton;
    private static final String TEST_MESSAGE = "TEST_MESSAGE ENTER";
    private String hintText = "Enter message here";

    @SuppressWarnings("deprecation")
    public MainActivityTest() {
        super ("com.agilefaqs.chatapp",MainActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = this.getActivity();
        messageInput = (EditText) mainActivity.findViewById(R.id.messageInput);
        sendMessageButton = (Button) mainActivity.findViewById(R.id.sendButton);
    }

    @Test
    public  void testHint() {
        assertEquals(hintText, messageInput.getHint().toString());
    }

    @Test
    public void testMessageSentFromEditViewAfterClickingSend() {
        sendKeys(TEST_MESSAGE);
        sendKeys("ENTER");
        assertEquals("", messageInput.getText().toString());
    }
}
