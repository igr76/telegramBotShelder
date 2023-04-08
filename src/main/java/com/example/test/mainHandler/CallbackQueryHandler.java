package main.java.com.example.test.mainHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import main.java.com.example.test.util.FormReplyMessages;
import main.java.com.example.test.textAndButtonsAndKeyboard.ConfigKeyboard;
import main.java.com.example.test.mainHandler.reportHandler.ReportAddHandler;
import main.java.com.example.test.mainHandler.RegistrationHandler;
import main.java.com.example.test.service.AdoptiveParentService;
import main.java.com.example.test.textAndButtonsAndKeyboard.AllText;
/**
 * Обработка сообщений от inline клавиатуры
 */
@Slf4j
@Component
public class CallbackQueryHandler {

  private final FormReplyMessages formReplyMessages;
  private final ConfigKeyboard configKeyboard;
  private final ReportAddHandler reportAddHandler;

  private final RegistrationHandler registrationHandler;
  private final AdoptiveParentService adoptiveParentService;


  public CallbackQueryHandler(FormReplyMessages formReplyMessages, ConfigKeyboard configKeyboard,
      ReportAddHandler reportAddHandler,
      RegistrationHandler registrationHandler, AdoptiveParentService adoptiveParentService) {
    this.formReplyMessages = formReplyMessages;
    this.configKeyboard = configKeyboard;
    this.reportAddHandler = reportAddHandler;
    this.registrationHandler = registrationHandler;
    this.adoptiveParentService = adoptiveParentService;
  }

  /**
   * обработка CallbackQuery ответа от пользователя
   *
   * @param callbackQuery информация о нажатой пользователем кнопке кнопке
   * @return SendMessage
   */
  public SendMessage handler(CallbackQuery callbackQuery) {

    log.debug("Вызов метода handler класса" + this.getClass().getName());

    SendMessage sendMessage = null;
    String textMessage = callbackQuery.getData();
    Message message = callbackQuery.getMessage();
    String chatId = message.getChatId().toString();
    switch (textMessage) {

//      case (AllText.SHOW_ALL_YOUR_PET_TEXT):     // нажатие кнопки показать всех взятых животных
//        sendMessage = reportAddHandler.clickButton_SHOW_ALL_YOUR_PET(message);
//        break;

//      case (AllText.SEND_REPORT_TEXT):     // нажатие кнопки отправить отчет
//        adoptiveParentService.updateStateAdoptiveParentByChatId(Long.parseLong(chatId),
//            StateAdoptiveParent.START_SEND_REPORT);
//        sendMessage = reportAddHandler.clickButton_SEND_REPORT(message);
//        break;
      case (AllText.REGISTRATION_BUTTON):     // нажатие кнопки регистрация
        return registrationHandler.addToTable(message, String.valueOf(message.getChatId()));

    }
    return sendMessage;
  }


}
