package Sketch.Core;

import Sketch.Core.Graph.ConnectedNode;
import Sketch.Core.Graph.TruncatedOrientedNodeSupplier;
import Sketch.Services.BlockchainInfoService;
import Sketch.Utils.Mapper;

public class BlockchainInfoWalletNodeSupplier extends TruncatedOrientedNodeSupplier<GraphicableWalletNode> {

    public BlockchainInfoWalletNodeSupplier(int maxDeepness) {
        super(maxDeepness);
    }

    @Override
    public ConnectedNode<GraphicableWalletNode> truncatedSupply(GraphicableWalletNode source, String id) {
        return Mapper.map(BlockchainInfoService.getInstance().getWallet(id), (
                wallet -> new ConnectedNode<>(new GraphicableWalletNode(wallet.getAddress(), source == null ? 0 : source.getIndex() + 1, wallet.getTotalReceived()), wallet.getOutAddresses())
        ));
    }
}
