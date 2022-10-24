package liga.medical.medicalmonitoring.core.anti_SOLID;

public class AntiS {
    class MessageService {
        //Класс выполняет несколько обязанностей и их лучше разделить и поместить в разные классы

        private Message message;

        public MessageService(Message message) {
            this.message = message;
        }

        public void save() {
            // save in DataBase
        }

        public void send(Message message) {
            // send message to user
        }

        public void messageHandler(Message message) {
            // handler message, sort, filter, group ...
        }
    }

    class Message {
        private String type;
        private String text;
        private String from;
        private String to;

        public Message(String type, String text, String from, String to) {
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
