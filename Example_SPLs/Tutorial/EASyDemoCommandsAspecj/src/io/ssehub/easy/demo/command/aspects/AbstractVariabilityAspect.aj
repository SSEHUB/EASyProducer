package io.ssehub.easy.demo.command.aspects;

abstract aspect AbstractVariabilityAspect {

    pointcut mainClass() : within(io.ssehub.easy.demo.command.aspects.Main);
    
    pointcut mainMethod() : mainClass() && execution(void main(String[]));
    
}