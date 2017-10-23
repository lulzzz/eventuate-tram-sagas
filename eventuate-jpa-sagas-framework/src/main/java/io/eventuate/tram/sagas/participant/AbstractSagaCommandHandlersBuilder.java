package io.eventuate.tram.sagas.participant;

import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public interface AbstractSagaCommandHandlersBuilder {
  <C> SagaCommandHandlerBuilder<C> onMessageReturningMessages(Class<C> commandClass,
                                                              Function<CommandMessage<C>, List<Message>> handler);

  <C> SagaCommandHandlerBuilder<C> onMessageReturningOptionalMessage(Class<C> commandClass,
                                                                     Function<CommandMessage<C>, Optional<Message>> handler);

  <C> SagaCommandHandlerBuilder<C> onMessage(Class<C> commandClass,
                                             Function<CommandMessage<C>, Message> handler);

  <C> SagaCommandHandlerBuilder<C> onMessage(Class<C> commandClass, Consumer<CommandMessage<C>> handler);
}
