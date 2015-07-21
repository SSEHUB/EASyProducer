package io.ssehub.easy.demo.command.aspects;

import io.ssehub.easy.demo.command.Processor;
import io.ssehub.easy.demo.command.commands.SubIntCommand;

aspect SubIntVariabilityAspect extends AbstractVariabilityAspect {

    before() : mainMethod() {
        Processor.register(new SubIntCommand());
    }
    
}