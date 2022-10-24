package liga.medical.medicalmonitoring.core.anti_SOLID;

public class AntiD {
    class MessageService {
        //Класс зависит от конкретных реализации, а по хорошемунужно создать
        //абстракцию в виде интерфейса для каждого сервиса и зависить от нее.
        //И в любое время можно поменять реализацию без проблем в проекте
        private Messages message;
        private MessageSaver saver;
        private MessageSender sender;
        private MessageHandler handler;

        public MessageService(Messages message, MessageSaver saver, MessageSender sender, MessageHandler handler) {
            this.message = message;
            this.saver = saver;
            this.sender = sender;
            this.handler = handler;
        }
    }

    class MessageSaver {
        public void save() {
            // save in DataBase
        }
    }

    class MessageSender {
        public void send(Messages message) {
            // send message to user
        }
    }

    class MessageHandler {
        public void messageHandler(Messages message) {
            // handler message, sort, filter, group ...
        }
    }

    class Messages {
        private String type;
        private String text;
        private String from;
        private String to;

        public Messages(String type, String text, String from, String to) {
            this.type = type;
            this.text = text;
            this.from = from;
            this.to = to;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }
    }
}
