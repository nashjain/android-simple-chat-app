
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.agilefaqs.chatapp.MainActivity;
import com.confengine.chatapp.R;


public class FirstUnitCase extends ActivityInstrumentationTestCase2<FirstUnitCase> {

    private MainActivity mainActivity;
    private EditText messageInput;
s

    @SuppressWarnings("deprecation")
    public FirstUnitCase() {
        super("com.agilefaqs.chatapp",MainActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = this.getActivity();
      messageInput=(EditText)mainActivity.findViewById(R.id.messageInput);

    }

    public void testCheckFieldNullInitialy() {
        assertEquals(messageInput.getText().toString(),null);
    }

    public void testCheckFieldAfterDecimalPointValues {
        sendKeys("4.000000000000");
        assertEquals("4.000000000000", messageInput.getText().toString());
    }

    public void testCheckClickable() {

        assertEquals(messageInput.isClickable(), true);
    }

    public void testCheckEditableAfterEnteringText() {

        messageInput.setText("HelloUser");
        assertEquals(messageInput.isClickable(), true);
        assertEquals(messageInput.isEnabled(), true);
    }


}