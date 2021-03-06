package com.srlupdater.updater.injection.analyzers;

import com.srlupdater.updater.injection.generic.AbstractAnalyzer;
import com.srlupdater.updater.injection.generic.Hook;
import com.srlupdater.updater.utils.Utils;
import org.objectweb.asm.tree.ClassNode;

public class StreamAnalyzer extends AbstractAnalyzer {

    @Override
    protected boolean canRun(ClassNode node) {
        if (!node.superName.endsWith(classNodes.get("Node").name) || classNodes.containsKey("Stream"))
            return false;
        if (node.methods.size() < 20)
            return false;
        return Utils.isConstructorDescriptor(node, "([B)V");
    }

    @Override
    protected Hook analyse(ClassNode node) {
        Hook hook = new Hook("Stream",node.name);
        classNodes.put("Stream",node);
        return hook;
    }
}
